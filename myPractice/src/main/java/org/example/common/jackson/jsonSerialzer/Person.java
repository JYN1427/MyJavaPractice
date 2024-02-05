package org.example.common.jackson.jsonSerialzer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/08/28 22:00:10
 * @Version: 1.0.0
 */

public class Person {
    public long personId = 0;
    public String name = "John";

    /**
     * 实现enabled属性的自定义序列化
     */
    @JsonSerialize(using = Serializers.OptimizedBooleanSerializer.class)
    public boolean enabled;

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", name='" + name + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
