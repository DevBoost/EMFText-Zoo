componentmodel org.emftext.language.egui.meta.egui_componentmodel_model
implements org.emftext.language.egui.meta.egui
epackages <http://www.emftext.org/language/egui>
rootclass egui::Application {

	fragment role Model {
		port type ScreenImport {
			egui::screenimport::ScreenImport is hook {
    			port = $self.name$ 
    		}
    		egui::screenmodel::Screen is value prototype {
    			port = $self.name$ 
    			value = $self.name$
    		}
    	}
    }
}