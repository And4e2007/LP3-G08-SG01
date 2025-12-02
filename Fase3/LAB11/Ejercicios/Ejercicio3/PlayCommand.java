package Ejercicio3;

class PlayCommand implements Command {
    private ReproductorMusica player;

    public PlayCommand(ReproductorMusica player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.play();
    }
}
