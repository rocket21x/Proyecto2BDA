package DTOss;

import DTOss.Licencia;
import java.time.LocalDate;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-04-11T13:48:54", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Persona.class)
public class Persona_ { 

    public static volatile SingularAttribute<Persona, LocalDate> fechaNacimiento;
    public static volatile SingularAttribute<Persona, String> nombreCompleto;
    public static volatile SingularAttribute<Persona, String> telefono;
    public static volatile SingularAttribute<Persona, String> RFC;
    public static volatile ListAttribute<Persona, Licencia> licencias;

}