package Cloc;
import java.util.Objects;
public class Clock {
    private int hours;
    private int minutes;

    public Clock(int hours, int minutes) {
        this.hours = (hours + (minutes / 60)) % 24;
        this.minutes = minutes % 60;
        if (this.minutes < 0) {
            this.minutes += 60;
            this.hours = (this.hours == 0) ? 23 : this.hours - 1;
        }
        if (this.hours < 0) {
            this.hours += 24;
        }
    }

    public void add(int minutes) {
        this.minutes += minutes;
        this.hours = (this.hours + (this.minutes / 60)) % 24;
        this.minutes %= 60;
        if (this.minutes < 0) {
            this.minutes += 60;
            this.hours = (this.hours == 0) ? 23 : this.hours - 1;
        }
        if (this.hours < 0) {
            this.hours += 24;
        }
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d", this.hours, this.minutes);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Clock clock = (Clock) obj;
        return hours == clock.hours && minutes == clock.minutes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hours, minutes);
    }
}
