package racingcar.domain;

public class Car {

    private Name name;
    private Distance distance;

    public Car(final String name) {
        this.name = Name.from(name);
        this.distance = Distance.from();
    }

    public void move(boolean isMove) {
        distance.move(isMove);
    }

    public Distance getDistance() {
        return this.distance;
    }

    public Name getName() {
        return this.name;
    }
}
