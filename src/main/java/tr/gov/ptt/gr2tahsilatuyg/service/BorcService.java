/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.ptt.gr2tahsilatuyg.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import tr.gov.ptt.gr2tahsilatuyg.entity.Borc;
import tr.gov.ptt.gr2tahsilatuyg.entity.Kurum;
import tr.gov.ptt.gr2tahsilatuyg.facade.BorcFacade;
import tr.gov.ptt.gr2tahsilatuyg.facade.KurumFacade;

@Stateless
public class BorcService {
    @EJB
    private BorcFacade borcFacade;
    
    @EJB
    private KurumFacade kurumFacade;
    
    public List<Borc> borclariGetir(Borc p_borc)
    {
        p_borc.getKurum().setId(new BigDecimal(kurumFacade.kurumIdGetir(p_borc.getKurum().getAd())));
        return borcFacade.borclariGetir(p_borc);
    }
    public List<String> tamamlaKurumAdi(String p_sorgu)
    {
      
        return kurumFacade.tamamlaKurumAdi(p_sorgu);
    }
     public int kurumIdGetir(String p_kurumAd){
       
     return kurumFacade.kurumIdGetir(p_kurumAd);
       
   }
    
    
}
