/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.ptt.gr2tahsilatuyg.service;

import java.util.List;
import javax.ejb.Stateless;
import tr.gov.ptt.gr2tahsilatuyg.entity.Borc;
import tr.gov.ptt.gr2tahsilatuyg.facade.BorcFacade;

@Stateless
public class BorcService {
    
    private BorcFacade borcFacade;
    
    public List<Borc> borclariGetir(Borc p_borc)
    {
        return borcFacade.borclariGetir(p_borc);
    }
    
}
