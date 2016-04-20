package testsEstaDisponible;

import com.ddsutn.group01.tpanual.models.pois.ParadaColectivo;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uqbar.geodds.Point;

public class ParadaDeColectivoDisponibilidadTest {
    private ParadaColectivo parada114;
    private DateTime horario;

    @Before
    public void init() {
        Point point = new Point(-34.603689, -58.381652);
        parada114 = new ParadaColectivo("114", point); // https://goo.gl/maps/NquccBrGJsz
        horario = new DateTime(2016, 4, 19, 10, 00, 00);
    }

    @Test
    public void paradaDisponible(){
    	Assert.assertTrue(parada114.estaDisponible(horario));
    }
}
