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
		egui::screenmodel::Screen if $name.contains('__')$ {
			fragment = $name$
			ufi = $name.substring(name.indexOf('__') + 3,name.length()).concat('.egui').split('\\_')$
		}
    }
    
    association import {
    	egui::screenmodel::Screen if $name.contains('__')$ {
			fragment = $name$
			-->
			fragment = $'CORE'$
			port = $self.name$
		}
    }
}