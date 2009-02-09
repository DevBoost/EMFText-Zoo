reuseextension ReuseJava
for    <http://www.emftext.org/java/containers>
{
	binding StatementVP {
		binding VP {
  			reusejava::StatementVariationPoint is hook {
    			port expr = $name$ 
    		}
    	}
	}
}