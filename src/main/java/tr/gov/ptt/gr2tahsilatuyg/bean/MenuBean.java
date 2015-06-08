/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.ptt.gr2tahsilatuyg.bean;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import tr.gov.ptt.gr2tahsilatuyg.entity.Menu;

@ManagedBean
@SessionScoped
public class MenuBean {
    
    @ManagedProperty(value = "#{kisiBean}")
    private KisiBean kisiBean;
    
    private MenuModel menuModel;

    public MenuBean() {
        
        menuModel = new DefaultMenuModel();
     
    }

    public void setKisiBean(KisiBean kisiBean) {
        this.kisiBean = kisiBean;
    }
    
    @PostConstruct
    public void initMenu()
    {
        DefaultSubMenu submenu = new DefaultSubMenu("Menü İşlemleri");
                
        //DefaultSubMenu girisCikisSub = new DefaultSubMenu("Giriş-Çıkış İşlemleri");
        
        DefaultMenuItem menuItem ;
        List<Menu> menuListe= kisiBean.getKisi().getTip().getMenuList();
        
        for(Menu menu:menuListe){
            
             menuItem=new DefaultMenuItem();
             menuItem.setValue(menu.getBaslik());
             menuItem.setCommand(menu.getLink());
             submenu.addElement(menuItem);
        }
        
//        menuItem.setValue("Kişi Ekle");
//        menuItem.setUrl("kisiEkle.xhtml?faces-redirect=true");
//        kisiSub.addElement(menuItem);
//        
//      menuItem =new DefaultMenuItem();
//        menuItem.setValue("Kişi Listele");
//        menuItem.setCommand("#{kisiBean.listele()}");
//        kisiSub.addElement(menuItem);
//        
//           menuItem =new DefaultMenuItem();
//        menuItem.setValue("Kişi Ara");
//        menuItem.setCommand("kisiAra.xhtml?faces-redirect=true");
//        kisiSub.addElement(menuItem);
//        
//          menuItem =new DefaultMenuItem();
//        menuItem.setValue("Giriş  İşlemleri");
//        menuItem.setCommand("giris.xhtml?faces-redirect=true");
//        girisCikisSub.addElement(menuItem);
//        
//        menuItem =new DefaultMenuItem();
//        menuItem.setValue("Çıkış İşlemleri");
//        menuItem.setCommand("#{girisBean.guvenliCikis()}");
//        girisCikisSub.addElement(menuItem);
 
        menuModel.addElement(submenu);
        //menuModel.addElement(girisCikisSub);
 
                
    }

    public MenuModel getMenuModel() {
        return menuModel;
    }
    
    
    
    
}
