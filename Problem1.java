// Time Complexity : O(logn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach 
//we use priority queue to store parkingspot and with priority of 
//smallest floor number and spot number, so every time new car wants a spot
//we give earliest available from pq and fpr unpar we again add it to the 
//priority queue.

import java.util.PriorityQueue;

class Main {
    static class ParkingSpot {
        int floor;
        int spot;

        public ParkingSpot(int floor, int spot) {
            this.floor = floor;
            this.spot = spot;
        }

        public int getSpot() {
            return this.spot;
        }

        public int getFloor() {
            return this.floor;
        }
    }

    static class ParkingLot {
        int maxFloors;
        int spotsPerFloor;
        PriorityQueue<ParkingSpot> pq = new PriorityQueue<>((a,b)->{
            if(a.floor==b.floor)return a.spot-b.spot;
            return a.floor-b.floor;
        });

        public ParkingLot(int maxFloors, int spotsPerFloor) {
            this.maxFloors = maxFloors;
            this.spotsPerFloor = spotsPerFloor;
        }

        public ParkingSpot park() {
            if(pq.isEmpty()) throw new IllegalStateException("Error: Parking lot is full");
            ParkingSpot result = pq.remove();
            return result;
        }

        public void unpark(int floor, int spot) {
            ParkingSpot newSpot = new ParkingSpot(floor,spot);
            pq.add(newSpot);
        }

        public ParkingSpot getNextAvailable() {
            return pq.peek();
        }

        public void addParkingSpot(int floor, int spot) {
            if (floor > maxFloors) {
                throw new IllegalArgumentException("Error floor input greater than max allowed");
            }
            if (spot > spotsPerFloor) {
                throw new IllegalArgumentException("Error: spots input greater than max allowed");
            }
            ParkingSpot newSpot = new ParkingSpot(floor,spot);
            pq.add(newSpot);
        }
    }

    public static void main(String[] args) {
        ParkingLot pl = new ParkingLot(3, 2);
        pl.addParkingSpot(1, 1);
        pl.addParkingSpot(2, 1);
        pl.addParkingSpot(3, 1);
        pl.addParkingSpot(1, 2);
        pl.addParkingSpot(2, 2);
        pl.addParkingSpot(3, 2);

        ParkingSpot n = pl.getNextAvailable();
        System.out.println("Parked at Floor: " + n.getFloor() + ", Slot: " + n.getSpot());
        pl.park();

        ParkingSpot n2 = pl.getNextAvailable();
        System.out.println("Parked at Floor: " + n2.getFloor() + ", Slot: " + n2.getSpot());
        pl.unpark(1, 1);

        ParkingSpot n1 = pl.getNextAvailable();
        System.out.println("Parked at Floor: " + n1.getFloor() + ", Slot: " + n1.getSpot());
    }
}
