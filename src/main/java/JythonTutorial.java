import lombok.extern.slf4j.Slf4j;
import org.python.core.PyFunction;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

import java.net.URL;

@Slf4j
public class JythonTutorial {

    public static void main(String[] args) {
        try (PythonInterpreter interpreter = new PythonInterpreter()) {

            URL pythonResource = JythonTutorial.class.getClassLoader().getResource("add.py");
            assert pythonResource != null;
            String file = pythonResource.getFile();

            interpreter.execfile(file);

            PyFunction pyFunction = interpreter.get("add", PyFunction.class);
            int a = 5;
            int b = 10;
            PyObject pyobj = pyFunction.__call__(new PyInteger(a), new PyInteger(b));
            log.info("the anwser is: {}", pyobj);
        }
    }
}
