/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.ptt.gr2tahsilatuyg.bean;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;
import tr.gov.ptt.gr2tahsilatuyg.entity.Kisi;
import tr.gov.ptt.gr2tahsilatuyg.service.KisiService;
import tr.gov.ptt.gr2tahsilatuyg.util.JSFUtil;

/**
 *
 * @author Administrator
 */
@ManagedBean
@SessionScoped
public class KisiBean {
    private Kisi kisi; 
    
    @EJB
    private KisiService kisiService;
    
      
    private List<String> temaListesi;

    public KisiBean() {
        
        kisi=new Kisi();
        kisi.setTema("start");
        temaListesi=new ArrayList<String>();
        temaListesiDoldur();
        kisi.setKullaniciAd("bora");
        kisi.setSifre("1234");
      
       
       
    }

    public List<String> getTemaListesi() {
        return temaListesi;
    }

    
    public void temaListesiDoldur(){
      
        temaListesi.add("afterdark");
        temaListesi.add("excite-bike");
        temaListesi.add("trontastic");
        temaListesi.add("south-street");
        temaListesi.add("humanity");
        temaListesi.add("blitzer");
        temaListesi.add("redmond");
        temaListesi.add("sunny");
        temaListesi.add("afternoon");
        
    }
    
  
       

    public Kisi getKisi() {
        return kisi;
    }

    public void setKisi(Kisi kisi) {
        this.kisi = kisi;
    }
    
    public String girisKontrol()
    {
        Kisi vtKisi=kisiService.girisKontrol(this.kisi);
        if(vtKisi !=null)
        {
           this.kisi=vtKisi;
           HttpSession session = JSFUtil.getSession();
           session.setAttribute("username", vtKisi.getKullaniciAd());
           return "menu.xhtml?faces-redirect=true";
        }else
        {
            JSFUtil.hatamesajEkle("Yanlış giriş", "Kullanıcı adı yada şifre yanlış");
            return "giris.xhtml?faces-redirect=true";
        }
       
    }
    
    public String guvenliCikis()
    {
         JSFUtil.sessionBitir();
         return "giris.xhtml?faces-redirect=true";
    }
    
       
    public void temaKaydet()
    {
       //kisi.setTema(seciliTema);
        
        kisiService.kisiGuncelle(kisi);
    }
    
            
    
    
}
