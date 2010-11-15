compositionlanguage org.emftext.language.egui.meta.egui_compositionlanguage
implements org.emftext.language.egui.meta.egui
epackages <http://www.emftext.org/language/egui>
rootclass egui::Application if $not (ufi.trimExtension().extension() = 'composed')$
ucpi = $ufi.trimExtension().appendExtension('ucl')$ 
location = $'out'$ {

	fragment role Model {
		egui::Application {
    		fragment = $'CORE'$
    		ufi = $ufi$
    		target ufi = $ufi.trimExtension().appendExtension('composed').appendExtension('egui')$
    		target location = $'out'$
    	}
    }
    
	fragment role Template { 
		egui::screenimport::ScreenImport {
			fragment = $self.name$
			ufi = $self.id.split('/')$
		}
	}
	fragment role Template { 
		egui::screenimport::ParameterSetting {
			fragment = $screenImport.name$
			ufi = $screenImport.id.split('/')$
			port Contents {
				$parameter$ = $value$
			}
		}
    }
    
    association import {
    	egui::screenimport::ScreenImport {
			fragment = $name$
			-->
			fragment = $'CORE'$
			port = $self.name$
		}
    }
}