reuseextension ReuseJava
for    <http://www.emftext.org/java/containers>
{
	binding StatementVP {
		binding VP {
  			reusejava::StatementVP is hook {
    			port expr = $name$ 
    		}
    	}
	}
	
	binding ReuseableStatement {
		binding Statements {
  			reusejava::StatementUnit.statements is prototype {
    			port expr = $name$ 
    		}
    	}
    }
}