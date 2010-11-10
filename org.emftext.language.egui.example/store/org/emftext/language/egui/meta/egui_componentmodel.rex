componentmodel org.emftext.language.egui.meta.egui_componentmodel
implements org.emftext.language.egui.meta.egui
epackages <http://www.emftext.org/language/egui>
rootclass egui::Application {

	fragment role Model {
		port type ScreenImport {
			egui::screenmodel::Screen is hook if $name.contains('__')$ {
    			port = $self.name$ 
    		}
    		egui::screenmodel::Screen is value prototype if $name.contains('__')$ {
    			port = $self.name$ 
    			value = $self.name.substring(1,name.indexOf('__'))$
    		}
    	}
    }
    
	fragment role Template { 
		port type Contents {
			egui::screenmodel::Screen is prototype if $name = '_SCREEN_TEMPLATE_'$ {
    			port = $self.name$ 
    		}
    		egui::screenmodel::Screen.name is value hook if $name = '_SCREEN_TEMPLATE_'$ {
    			port = $self.name$ 
    		}
    	}
    }
}