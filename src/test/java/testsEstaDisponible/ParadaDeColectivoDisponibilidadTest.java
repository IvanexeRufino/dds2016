package testsEstaDisponible;

import java.time.LocalDateTime;

import org.junit.*;
import org.uqbar.geodds.*;

import com.ddsutn.group01.tpanual.models.pois.ParadaColectivo;

public class ParadaDeColectivoDisponibilidadTest {
    private Point point;
    ParadaColectivo parada114; 
    
    @Before
    public void init() {
        point = new Point(-34.603689, -58.381652); 
        // https://goo.gl/maps/NquccBrGJsz
        parada114 = new ParadaColectivo("114",point);    
    }
    
    @Test
    public void paradaDisponible(){
    	LocalDateTime horario = LocalDateTime.of(2016, 4,19,10,0);
    	Assert.assertTrue(parada114.estaDisponible(horario));
    }
    
}
