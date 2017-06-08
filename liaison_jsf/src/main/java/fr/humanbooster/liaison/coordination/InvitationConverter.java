//package fr.humanbooster.liaison.coordination;
//
//import javax.faces.application.FacesMessage;
//import javax.faces.component.UIComponent;
//import javax.faces.context.FacesContext;
//import javax.faces.convert.Converter;
//import javax.faces.convert.ConverterException;
//import javax.faces.convert.FacesConverter;
//
//import fr.humanbooster.liaison.business.Invitation;
//import fr.humanbooster.liaison.service.InvitationService;
//import fr.humanbooster.liaison.service.impl.InvitationServiceImpl;
//
//@FacesConverter("invitationConverter")
//public class InvitationConverter implements Converter{
//
//	@Override
//	public Object getAsObject(FacesContext context, UIComponent component, String value) {
//		if(value != null && value.trim().length() > 0) {
//            try {
//            	InvitationService service = (InvitationServiceImpl) context.getExternalContext().getApplicationMap().get("invitationServiceImpl");
//                return service.getAllInvitations().get(Integer.parseInt(value));
//            } catch(NumberFormatException e) {
//                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
//            }
//        }
//        else {
//            return null;
//        }
//	}
//
//	@Override
//	public String getAsString(FacesContext context, UIComponent component, Object value) {
//		if(value != null) {
//            return String.valueOf(((Invitation) value).getId());
//        }
//        else {
//            return null;
//        }
//	}
//
//}
