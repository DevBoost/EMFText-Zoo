/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
/*
 [The "BSD license"]
 Copyright (c) 2005-2009 Terence Parr
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions
 are met:
 1. Redistributions of source code must retain the above copyright
     notice, this list of conditions and the following disclaimer.
 2. Redistributions in binary form must reproduce the above copyright
     notice, this list of conditions and the following disclaimer in the
     documentation and/or other materials provided with the distribution.
 3. The name of the author may not be used to endorse or promote products
     derived from this software without specific prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.antlr.runtime3_4_0;

/** A DFA implemented as a set of transition tables.
 *
 *  Any state that has a semantic predicate edge is special; those states
 *  are generated with if-then-else structures in a specialStateTransition()
 *  which is generated by cyclicDFA template.
 *
 *  There are at most 32767 states (16-bit signed short).
 *  Could get away with byte sometimes but would have to generate different
 *  types and the simulation code too.  For a point of reference, the Java
 *  lexer's Tokens rule DFA has 326 states roughly.
 */
public class DFA {
	protected short[] eot;
	protected short[] eof;
	protected char[] min;
    protected char[] max;
    protected short[] accept;
    protected short[] special;
    protected short[][] transition;

	protected int decisionNumber;

	/** Which recognizer encloses this DFA?  Needed to check backtracking */
	protected BaseRecognizer recognizer;

	public static final boolean debug = false;

	/** From the input stream, predict what alternative will succeed
	 *  using this DFA (representing the covering regular approximation
	 *  to the underlying CFL).  Return an alternative number 1..n.  Throw
	 *  an exception upon error.
	 */
	public int predict(IntStream input)
		throws RecognitionException
	{
		if ( debug ) {
			System.err.println("Enter DFA.predict for decision "+decisionNumber);
		}
		int mark = input.mark(); // remember where decision started in input
		int s = 0; // we always start at s0
		try {
			while ( true ) {
				if ( debug ) System.err.println("DFA "+decisionNumber+" state "+s+" LA(1)="+(char)input.LA(1)+"("+input.LA(1)+
												"), index="+input.index());
				int specialState = special[s];
				if ( specialState>=0 ) {
					if ( debug ) {
						System.err.println("DFA "+decisionNumber+
							" state "+s+" is special state "+specialState);
					}
					s = specialStateTransition(specialState,input);
					if ( debug ) {
						System.err.println("DFA "+decisionNumber+
							" returns from special state "+specialState+" to "+s);
					}
					if ( s==-1 ) {
						noViableAlt(s,input);
						return 0;
					}
					input.consume();
					continue;
				}
				if ( accept[s] >= 1 ) {
					if ( debug ) System.err.println("accept; predict "+accept[s]+" from state "+s);
					return accept[s];
				}
				// look for a normal char transition
				char c = (char)input.LA(1); // -1 == \uFFFF, all tokens fit in 65000 space
				if (c>=min[s] && c<=max[s]) {
					int snext = transition[s][c-min[s]]; // move to next state
					if ( snext < 0 ) {
						// was in range but not a normal transition
						// must check EOT, which is like the else clause.
						// eot[s]>=0 indicates that an EOT edge goes to another
						// state.
						if ( eot[s]>=0 ) {  // EOT Transition to accept state?
							if ( debug ) System.err.println("EOT transition");
							s = eot[s];
							input.consume();
							// TODO: I had this as return accept[eot[s]]
							// which assumed here that the EOT edge always
							// went to an accept...faster to do this, but
							// what about predicated edges coming from EOT
							// target?
							continue;
						}
						noViableAlt(s,input);
						return 0;
					}
					s = snext;
					input.consume();
					continue;
				}
				if ( eot[s]>=0 ) {  // EOT Transition?
					if ( debug ) System.err.println("EOT transition");
					s = eot[s];
					input.consume();
					continue;
				}
				if ( c==(char)Token.EOF && eof[s]>=0 ) {  // EOF Transition to accept state?
					if ( debug ) System.err.println("accept via EOF; predict "+accept[eof[s]]+" from "+eof[s]);
					return accept[eof[s]];
				}
				// not in range and not EOF/EOT, must be invalid symbol
				if ( debug ) {
					System.err.println("min["+s+"]="+min[s]);
					System.err.println("max["+s+"]="+max[s]);
					System.err.println("eot["+s+"]="+eot[s]);
					System.err.println("eof["+s+"]="+eof[s]);
					for (int p=0; p<transition[s].length; p++) {
						System.err.print(transition[s][p]+" ");
					}
					System.err.println();
				}
				noViableAlt(s,input);
				return 0;
			}
		}
		finally {
			input.rewind(mark);
		}
	}

	protected void noViableAlt(int s, IntStream input) throws NoViableAltException {
		if (recognizer.state.backtracking>0) {
			recognizer.state.failed=true;
			return;
		}
		NoViableAltException nvae =
			new NoViableAltException(getDescription(),
									 decisionNumber,
									 s,
									 input);
		error(nvae);
		throw nvae;
	}

	/** A hook for debugging interface */
	protected void error(NoViableAltException nvae) { ; }

	public int specialStateTransition(int s, IntStream input)
		throws NoViableAltException
	{
		return -1;
	}

	public String getDescription() {
		return "n/a";
	}

	/** Given a String that has a run-length-encoding of some unsigned shorts
	 *  like "\1\2\3\9", convert to short[] {2,9,9,9}.  We do this to avoid
	 *  static short[] which generates so much init code that the class won't
	 *  compile. :(
	 */
	public static short[] unpackEncodedString(String encodedString) {
		// walk first to find how big it is.
		int size = 0;
		for (int i=0; i<encodedString.length(); i+=2) {
			size += encodedString.charAt(i);
		}
		short[] data = new short[size];
		int di = 0;
		for (int i=0; i<encodedString.length(); i+=2) {
			char n = encodedString.charAt(i);
			char v = encodedString.charAt(i+1);
			// add v n times to data
			for (int j=1; j<=n; j++) {
				data[di++] = (short)v;
			}
		}
		return data;
	}

	/** Hideous duplication of code, but I need different typed arrays out :( */
	public static char[] unpackEncodedStringToUnsignedChars(String encodedString) {
		// walk first to find how big it is.
		int size = 0;
		for (int i=0; i<encodedString.length(); i+=2) {
			size += encodedString.charAt(i);
		}
		char[] data = new char[size];
		int di = 0;
		for (int i=0; i<encodedString.length(); i+=2) {
			char n = encodedString.charAt(i);
			char v = encodedString.charAt(i+1);
			// add v n times to data
			for (int j=1; j<=n; j++) {
				data[di++] = v;
			}
		}
		return data;
	}

	/*
	public int specialTransition(int state, int symbol) {
		return 0;
	}
	*/
}
