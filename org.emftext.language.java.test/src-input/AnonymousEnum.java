public enum AnonymousEnum {
    CONSTANT_WITHOUT_BRACES {
        public void m1() {
        }
    },

    CONSTANT_WITH_BRACES() {
        public void m1() {
        }
    };
}
