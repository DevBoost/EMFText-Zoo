reuseextension ReuseJava
for    <http://www.emftext.org/reusejava>
{
	binding ReuseableStatement {
		binding Statements {
  			reusejava::StatementUnit.statements is prototype {
    			port expr = $name$ 
    		}
    	}
    }
}