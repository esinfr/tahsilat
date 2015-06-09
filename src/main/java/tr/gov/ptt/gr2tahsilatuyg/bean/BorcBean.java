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
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import tr.gov.ptt.gr2tahsilatuyg.entity.Borc;
import tr.gov.ptt.gr2tahsilatuyg.service.BorcService;

/**
 *
 * @author Administrator
 */
@ManagedBean
@SessionScoped
public class BorcBean {
    
    private Borc borc;
    
    private List<Borc> borcListesi;
    
    private List<Borc> seciliBorclar;

    public List<Borc> getBorcListesi() {
        return borcListesi;
    }

    public void setBorcListesi(List<Borc> borcListesi) {
        this.borcListesi = borcListesi;
    }
    
    @EJB
    private BorcService borcService;
    
    
    public BorcBean() {
        borc=new Borc();
        borcListesi=new ArrayList<Borc>();
        seciliBorclar = new ArrayList<Borc>();
    }


    public Borc getBorc() {
        return borc;
    }

    public List<Borc> getSeciliBorclar() {
        return seciliBorclar;
    }

    public void setSeciliBorclar(List<Borc> seciliBorclar) {
        this.seciliBorclar = seciliBorclar;
    }
    

    public void setBorc(Borc borc) {
        this.borc = borc;
    }

   public String borcListele()
   {
       borcListesi = borcService.borclariGetir(borc);
       borc=borcListesi.get(0);
       return "tahsilatListele.xhtml?faces-redirect=true";
       
   }
     
   public List<String> tamamlaKurumAdi(String p_sorgu)
    {
      
        return borcService.tamamlaKurumAdi(p_sorgu);
    }
   
      
//    public int kurumIdGetir(String p_kurumAd){
//       
//     return borcService.kurumIdGetir(p_kurumAd);
//    }
    
    
}
