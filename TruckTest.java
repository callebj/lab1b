package com.company;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;

class TruckTest {
    TruckTransporter tt = new TruckTransporter();
    Saab95 s = new Saab95();
    Volvo240 v = new Volvo240();
    Volvo240 v2 = new Volvo240();


    @Test
    void loadCarOnTruck() {
        tt.lowerTruckBed();
        tt.loadCarOnTruck(s);
        tt.loadCarOnTruck(v);
        tt.loadCarOnTruck(v2);

        assertThat(tt.truckTransporterTrunk, hasItems(s));
        assertThat(tt.truckTransporterTrunk, hasItems(v));
        assertThat(tt.truckTransporterTrunk, hasItems(v2));
    }

    @Test
    void removeCarFromTruck() {
        tt.lowerTruckBed();
        tt.loadCarOnTruck(s);
        tt.loadCarOnTruck(v);
        tt.loadCarOnTruck(v2);

        tt.removeCarFromTruck();
        tt.removeCarFromTruck();

        assertThat(tt.truckTransporterTrunk, hasItems(s));
    }
}