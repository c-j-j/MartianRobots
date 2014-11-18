package instruction;

import data.Position;

public enum Orientation {
    NORTH {
        @Override
        public Position turnRight(Position currentPosition) {
            return null;
        }

        @Override
        public Position turnLeft(Position currentPosition) {
            return null;
        }

        @Override
        public Position forward(Position currentPosition) {
            return null;
        }
    },
    EAST {
        @Override
        public Position turnRight(Position currentPosition) {
            return null;
        }

        @Override
        public Position turnLeft(Position currentPosition) {
            return null;
        }

        @Override
        public Position forward(Position currentPosition) {
            return null;
        }
    },
    SOUTH {
        @Override
        public Position turnRight(Position currentPosition) {
            return null;
        }

        @Override
        public Position turnLeft(Position currentPosition) {
            return null;
        }

        @Override
        public Position forward(Position currentPosition) {
            return null;
        }
    },
    WEST {
        @Override
        public Position turnRight(Position currentPosition) {
            return null;
        }

        @Override
        public Position turnLeft(Position currentPosition) {
            return null;
        }

        @Override
        public Position forward(Position currentPosition) {
            return null;
        }
    };


    public abstract Position turnRight(Position currentPosition);
    public abstract Position turnLeft(Position currentPosition);
    public abstract Position forward(Position currentPosition);
}
