package Ejercicio3;

class PauseCommand implements Command {
    private ReproductorMusica player;

    public PauseCommand(ReproductorMusica player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.pause();
    }
}
