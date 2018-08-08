package gadgetinspector.config;

import gadgetinspector.ImplementationFinder;
import gadgetinspector.SourceDiscovery;
import gadgetinspector.data.InheritanceMap;
import gadgetinspector.data.MethodReference;
import gadgetinspector.javaserial.SimpleImplementationFinder;
import gadgetinspector.javaserial.SimpleSerializableDecider;
import gadgetinspector.javaserial.SimpleSourceDiscovery;

import java.util.Map;
import java.util.Set;

public class JavaDeserializationConfig implements GIConfig {

    @Override
    public String getName() {
        return "jserial";
    }

    @Override
    public ImplementationFinder getImplementationFinder(Map<MethodReference.Handle, MethodReference> methodMap,
                                                        Map<MethodReference.Handle, Set<MethodReference.Handle>> methodImplMap,
                                                        InheritanceMap inheritanceMap) {
        return new SimpleImplementationFinder(new SimpleSerializableDecider(inheritanceMap), methodImplMap);
    }

    @Override
    public SourceDiscovery getSourceDiscovery() {
        return new SimpleSourceDiscovery();
    }
}
