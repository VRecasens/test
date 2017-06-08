package fr.humanbooster.liaison.coordination;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

import org.primefaces.model.UploadedFile;
 
@ManagedBean
public class FileUploadView {
     
    private UploadedFile file;
 
    public UploadedFile getFile() {
        return file;
    }
 
    public void setFile(UploadedFile file) {
        this.file = file;
    }
     
    public void upload() {
        if(file != null) {
            FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
            HttpSession session = SessionBean.getSession();
            BufferedImage bi;
			try {
				URL url = new URL("http://image.jeuxvideo.com/medias/148846/1488460632-5766-capture-d-ecran.jpg");
				bi = ImageIO.read(url);
	            File outputfile = new File("liaison_jsf/src/main/resources/img/" + session.getAttribute("idPersonne").toString() + ".jpg");
	            ImageIO.write(bi, "jpg", outputfile);
	            System.out.println("img sauvegardée");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
        }
    }
}