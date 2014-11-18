package instruction;

import data.Position;

public enum Orientation {
    NORTH {
        @Override
        public Position goForward(Position currentPosition) {
            return null;
        }
    },
    EAST {
        @Override
        public Position goForward(Position currentPosition) {
            return null;
        }
    },
    SOUTH {
        @Override
        public Position goForward(Position currentPosition) {
            return null;
        }
    },
    WEST {
        @Override
        public Position goForward(Position currentPosition) {
            return null;
        }
    };

    public abstract Position goForward(Position currentPosition);
}
