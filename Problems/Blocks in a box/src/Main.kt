data class Block(val color: String) {
    object DimProperties {
        var length = 0
        var width = 0
        fun blocksInBox(length: Int, width: Int): Int {
            return length / this.length * (width / this.width)
        }
    }
}
