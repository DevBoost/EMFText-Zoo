componentmodel org.emftext.language.egui.meta.egui
implements org.reuseware.lib.systems.default
epackages <http://www.emftext.org/language/egui>
rootclass egui::Application {

	fragment role Default {
		port type Rec {
			egui::screenmodel::Composite.children is hook {
    			port = $self.name$ 
    		}
    	}
    }
    
	fragment role Default if $not oclIsTypeOf(egui::screenmodel::Composite)$ { 
		port type Contrib {
			egui::screenmodel::Widget is prototype {
    			port = $self.name$ 
    		}
    	}
    }
}