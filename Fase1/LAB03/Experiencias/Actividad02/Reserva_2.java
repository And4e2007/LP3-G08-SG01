package Actividad02;

import java.util.Date;

public class Reserva_2 {
    private int id;
    private Date fechaReserva;
    private Date fechaCheckIn;
    private double montoTotal;
    private PoliticaCancelacion_2 politicaCancelacion;

    public Reserva_2(int id, Date fechaReserva, Date fechaCheckIn, double montoTotal, PoliticaCancelacion_2 politicaCancelacion) {
        this.id = id;
        this.fechaReserva = fechaReserva;
        this.fechaCheckIn = fechaCheckIn;
        this.montoTotal = montoTotal;
        this.politicaCancelacion = politicaCancelacion;
    }

    public boolean cancelar() {
        if (politicaCancelacion.puedeCancelar(this)) {
            System.out.println("Reserva cancelada sin problemas.");
            return true;
        } else {
            double penalizacion = politicaCancelacion.calcularPenalizacion(this);
            System.out.println("No se puede cancelar libremente. Penalización: $" + penalizacion);
            return false;
        }
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	public Date getFechaCheckIn() {
		return fechaCheckIn;
	}

	public void setFechaCheckIn(Date fechaCheckIn) {
		this.fechaCheckIn = fechaCheckIn;
	}

	public double getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(double montoTotal) {
		this.montoTotal = montoTotal;
	}

	public PoliticaCancelacion_2 getPoliticaCancelacion() {
		return politicaCancelacion;
	}

	public void setPoliticaCancelacion(PoliticaCancelacion_2 politicaCancelacion) {
		this.politicaCancelacion = politicaCancelacion;
	}

    // Getters y Setters
    
}
