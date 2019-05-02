
public class Block {
    Flat[] flats;

    // inner class
    class Flat {
        Room[] rooms;

        // inner class
        class Room {
            private int width;
            private int height;
            private int numWindow;

            // constructor
            // Fill in the marked area
            // Do not change anything else
            // For each creating room object, array "rooms" must be extended
            // Clearly, add new Room to end of array, update the array
            public Room(int width, int height, int numWindow) {
                super();
                this.width = width;
                this.height = height;
                this.numWindow = numWindow;

                //**********************************************
                if(rooms.length==0){
                    rooms= new Room[1];
                    rooms[0]=this;
                }else{
                    Room[] rooms2=new Room[rooms.length+1];
                    System.arraycopy(rooms,0,rooms2,0,rooms.length);
                    rooms2[rooms.length]=this;
                    rooms=new Room[rooms2.length];
                    System.arraycopy(rooms2,0,rooms,0,rooms2.length);
                }

                //**********************************************
            }

            // Please do not change anything in this method.
            @Override
            public String toString() {
                return width + "/" + height + "/" + numWindow;
            }
        }

        // constructor
        // Fill in the marked area
        // Do not change anything else
        // For each creating flat object, array "flats" must be extended
        // Clearly, add new Flat to end of array, update the array
        public Flat() {
            super();
            rooms = new Room[0];

            //**********************************************
            if(flats.length==0){
                flats= new Flat[1];
                flats[0]=this;
            }else{
                Flat[] flats2=new Flat[flats.length+1];
                System.arraycopy(flats,0,flats2,0,flats.length);
                flats2[flats.length]=this;
                flats=new Flat[flats2.length];
                System.arraycopy(flats2,0,flats,0,flats2.length);
            }
                //**********************************************

        }
    }

    // static inner class
    static class Process {

        // Fill in the blanks
        // Return number of flats in given block object
        // You must write it as one return command
        static int getNumFlat(Block b) {
            return b.flats.length;
        }

        // Fill in the blanks
        // Return number of rooms in given flat object
        // You must write it as one return command
        static int getNumRoom(Flat f) {
            return f.rooms.length;
        }

        // Fill in the blanks
        // Return height of given room object
        // You must write it as one return command
        static int getHeightRoom(Flat.Room r) {
            return r.height;
        }

        // Fill in the blanks
        // Return width of given room object
        // You must write it as one return command
        static int getWidthRoom(Flat.Room r) {
            return r.width;
        }

        // Fill in the blanks
        // Return numWindow of given room object
        // You must write it as one return command
        static int getNumWindowRoom(Flat.Room r) {
            return r.numWindow;
        }

        // Fill in the blanks
        // Return total number of rooms in given block object
        static int getTotalNumRoom(Block b) {
            int sum = 0;
            for (int i = 0; i < b.flats.length; i++) {
                for (int j = 0; j < b.flats[i].rooms.length; j++) {
                    sum++;
                }
            }
            return sum;
        }

        // Fill in the blanks
        // Return true, if given room object is a square
        // Return false, if else
        // You must write it as one return command
        static boolean isSquare(Flat.Room r) {
            return (r.width==r.height);
        }

        // Fill in the blanks
        // Scan all rooms in given block object
        // Find the room which has maximum area
        // Return it
        static Flat.Room findMaxRoomArea(Block b) {
            Block.Flat a = b.new Flat();
            Block.Flat.Room max = a.new Room(0, 0, 0);

            for (int i = 0; i < b.flats.length; i++) {
                for (int j = 0; j < b.flats[i].rooms.length; j++) {
                    if (b.flats[i].rooms[j].width * b.flats[i].rooms[j].height > max.height * max.width) {
                        max = b.flats[i].rooms[j];
                    }
                }
            }
            return max;
        }
    }

    // constructor
    // Please do not change anything in this constructor
    public Block() {
        super();
        flats = new Flat[0];
    }

}