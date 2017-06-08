//package fr.humanbooster.liaison.coordination;
//
//
//import javax.faces.application.FacesMessage;
//import javax.faces.component.UIComponent;
//import javax.faces.context.FacesContext;
//import javax.faces.convert.Converter;
//import javax.faces.convert.ConverterException;
//import javax.faces.convert.FacesConverter;
//
//import fr.humanbooster.liaison.business.Personne;
//import fr.humanbooster.liaison.service.PersonneService;
//import fr.humanbooster.liaison.service.impl.PersonneServiceImpl;
//
//@FacesConverter("personneConverter")
//public class PersonneConverter  implements Converter{
//
//	@Override
//	public Object getAsObject(FacesContext context, UIComponent component, String value) {
//		if(value != null && value.trim().length() > 0) {
//            try {
//            	PersonneService service = (PersonneServiceImpl) context.getExternalContext().getApplicationMap().get("personneServiceImpl");
//                return service.getAllPersons().get(Integer.parseInt(value));
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
//		if (value == null) {
//            return null; // Or an empty string, can also.
//        }
//
//        if (!(value instanceof Personne)) {
////           throw new ConverterException("The value is not a valid Personne: " + value);
//        	System.out.println("Exception Convert");
//        }
//
//        Integer id = ((Personne) value).getId();
//        return (id != null) ? String.valueOf(id) : null;
//	}
//
//}