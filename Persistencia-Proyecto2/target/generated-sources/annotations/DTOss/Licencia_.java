package DTOss;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-04-15T14:56:23", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Licencia.class)
public class Licencia_ { 

    public static volatile SingularAttribute<Licencia, Integer> vigencia;
    public static volatile SingularAttribute<Licencia, Date> fechaExpedicion;
    public static volatile SingularAttribute<Licencia, String> tipo;
    public static volatile SingularAttribute<Licencia, BigDecimal> monto;
    public static volatile SingularAttribute<Licencia, String> RFC;
    public static volatile SingularAttribute<Licencia, Integer> numeroLicencia;

}