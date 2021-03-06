package foundation.stack.datamill.configuration.impl;

import foundation.stack.datamill.configuration.PropertySource;
import foundation.stack.datamill.values.StringValue;
import foundation.stack.datamill.values.Value;
import rx.functions.Action1;

import java.util.Optional;

/**
 * @author Ravi Chodavarapu (rchodava@gmail.com)
 */
public abstract class AbstractSource implements PropertySource {
    @Override
    public Value getRequired(String name) {
        Optional<String> value = get(name);
        if (value.isPresent()) {
            return new StringValue(value.get());
        }

        throw new IllegalArgumentException("Required property " + name + " could not be found in chain!");
    }

    @Override
    public PropertySource with(Action1<PropertySource> propertiesConsumer) {
        propertiesConsumer.call(this);
        return this;
    }
}
