import models.*;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import planes.*;

import java.util.Arrays;
import java.util.List;

public class AirportTest {
    private static List<Plane> planes = Arrays.asList(
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
            new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
            new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
            new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
            new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
            new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER),
            new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryType.FIGHTER),
            new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryType.FIGHTER),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT),
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalTypes.HIGH_ALTITUDE, ClassificationLevel.SECRET),
            new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalTypes.VTOL, ClassificationLevel.TOP_SECRET)
    );

    private static final PassengerPlane PLANE_WITH_MAX_PASSENGER_CAPACITY = new PassengerPlane("Boeing-747", 980, 16100, 70500, 242);
    private Airport airport;

    @BeforeTest
    private void initializeAirport() {
        airport = new Airport(planes);
    }

    @Test
    public void testTransportMilitaryPlanesHasNoOtherMilitaryTypes() {
        Assert.assertFalse(airport.getTransportMilitaryPlanes().stream()
                .anyMatch(militaryPlane -> militaryPlane.getType() != MilitaryType.TRANSPORT));
    }

    @Test
    public void testGetPassengerPlaneWithMaxPassengersCapacity() {
        Assert.assertEquals(airport.getPassengerPlaneWithMaxPassengersCapacity(), PLANE_WITH_MAX_PASSENGER_CAPACITY);
    }

    @Test
    public void testSortByMaxLoadCapacity() {
        List<? extends Plane> planesSortedByMaxLoadCapacity = airport.sortByMaxLoadCapacity().getPlanes();

        Plane previous = planesSortedByMaxLoadCapacity.get(0);

        for (Plane plane : planesSortedByMaxLoadCapacity) {
            Assert.assertTrue(previous.getMaxLoadCapacity().compareTo(plane.getMaxLoadCapacity()) <= 0);
            previous = plane;
        }

        for (int i = 0; i < planesSortedByMaxLoadCapacity.size() - 1; i++) {
            Plane currentPlane = planesSortedByMaxLoadCapacity.get(i);
            Plane nextPlane = planesSortedByMaxLoadCapacity.get(i + 1);

            Assert.assertTrue(currentPlane.getMaxLoadCapacity() <= nextPlane.getMaxLoadCapacity());
        }
    }

    @Test
    public void testAtLeastOneBomberInMilitaryPlanes() {
        Assert.assertTrue(airport.getMilitaryPlanes().stream()
                .anyMatch(militaryPlane -> militaryPlane.getType() == MilitaryType.BOMBER));
    }

    @Test
    public void testExperimentalPlanesHasNoUnclassifiedPlanes(){
        Assert.assertFalse(airport.getExperimentalPlanes().stream()
                .anyMatch(experimentalPlane -> experimentalPlane.getClassificationLevel() == ClassificationLevel.UNCLASSIFIED));
    }
}
