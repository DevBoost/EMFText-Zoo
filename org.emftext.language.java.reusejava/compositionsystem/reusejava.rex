reuseextension ReuseJava
for    <http://www.emftext.org/java/containers>
{
	binding EmptyMethodBody {
		binding Member {
  			members::Field is anchor {
    			port expr = $name$ 
    		}
    	}
		binding Hook {
 			statements::Block.statements is hook if $statements->isEmpty() and eContainer().oclIsTypeOf(members::Method)$ {
 			    port expr = $eContainer().oclAsType(members::Method).name$
 			}
		} 
    }

	binding ReuseableStatement {
		binding MemberSlot {
  			reusejava::MemberSlot is slot {
    			port expr = $name$ 
    		}
    	}
		binding Statement {
 			reusejava::StatementPrototype.statement is prototype  {
 			    port expr = $name$
 			}
		} 
    }
}