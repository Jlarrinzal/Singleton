import java.util.HashMap;
import java.util.ResourceBundle;

public class I18NManager {

    private static I18NManager instance;

    private HashMap<String, ResourceBundle> data;

    public static I18NManager getInstance(){
        if(instance == null){
            instance = new I18NManager();
        }
        return instance;
    }

    private I18NManager(){
        data = new HashMap<>();
    }
    public void clear(){
        data.clear();
    }

    public String getText(String idioma, String clave) {
        ResourceBundle rb = data.get(clave);
        try {
            if (rb == null){
                rb = ResourceBundle.getBundle( "i18n."+idioma);
                data.put(clave, rb);
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return rb.getString(idioma);
    }
}
