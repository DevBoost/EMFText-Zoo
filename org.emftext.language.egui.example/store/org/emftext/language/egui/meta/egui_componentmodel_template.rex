componentmodel org.emftext.language.egui.meta.egui_componentmodel_template
implements org.emftext.language.egui.meta.egui
epackages <http://www.emftext.org/language/egui>
rootclass egui::screenimport::ScreenTemplate {
	fragment role Template { 
		port type Contents {
			egui::screenmodel::Screen is prototype {}
    		egui::screenmodel::Screen.name is value hook {}
    		egui::widgets::Text.text is value hook if $text.contains('<<') and text.contains('>>')$ {
    			point = $text.substring(text.indexOf('<<')+3, text.indexOf('>>'))$
    			begin idx = $text.indexOf('<<')$
    			end idx = $text.indexOf('>>')+3$
    		}
    	}
    }
}