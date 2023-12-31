/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladorDao;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.StreamException;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Marylin
 */
public class Conexion {

    private XStream xstream;
    public static String URL = "data/";

    private void conectar() {
        xstream = new XStream(new JettisonMappedXmlDriver());
        //xstream = new XStream(new JsonHierarchicalStreamDriver());
        xstream.setMode(XStream.NO_REFERENCES);
        xstream.addPermission(AnyTypePermission.ANY);
    }

    public XStream getXstream() {
        if (xstream == null) {
            conectar();
        }

        return xstream;
    }

    public void setXstream(XStream xstream) {
        this.xstream = xstream;
    }

}
