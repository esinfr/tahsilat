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
import tr.gov.ptt.gr2tahsilatuyg.entity.Borc;
import tr.gov.ptt.gr2tahsilatuyg.service.BorcService;

/**
 *
 * @author Administrator
 */
@ManagedBean
@RequestScoped
public class BorcBean {
    
    private Borc borc;
    
    private List<Borc> borcListesi;
    
    @EJB
    private BorcService borcService;
    
    
    public BorcBean() {
        borc=new Borc();
        borcListesi=new ArrayList<Borc>();
    }


    public Borc getBorc() {
        return borc;
    }

    public void setBorc(Borc borc) {
        this.borc = borc;
    }

   public String borcListele()
   {
       borcListesi = borcService.borclariGetir(borc);
       return "tahsilatListele.xhtml?faces-redirect=true";
       
   }
     
    
    
}
