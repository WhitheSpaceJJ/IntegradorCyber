package interfaces;


import entidades.Merma;
import java.util.Calendar;
import java.util.List;

public interface IMermaDAO extends IDAO<Merma> {

    List<Merma> buscarEntre(Calendar inicio, Calendar fin);
}
