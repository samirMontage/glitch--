package net.glitch.client.setting;

public class Setting<T> {
    private final String name;
    private T value;
    private T min;
    private T max;

    // Конструктор для чекбоксов (Boolean) или текстовых режимов
    public Setting(String name, T defaultValue) {
        this.name = name;
        this.value = defaultValue;
    }

    // Конструктор для слайдеров (чисел)
    public Setting(String name, T defaultValue, T min, T max) {
        this.name = name;
        this.value = defaultValue;
        this.min = min;
        this.max = max;
    }

    public String getName() { return name; }
    public T getValue() { return value; }
    public void setValue(T value) { this.value = value; }
    public T getMin() { return min; }
    public T getMax() { return max; }
}
