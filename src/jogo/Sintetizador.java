package jogo;

import javax.speech.AudioException;
import javax.speech.Central;
import javax.speech.EngineException;
import javax.speech.EngineStateError;
import javax.speech.synthesis.Synthesizer;

public class Sintetizador {
	private Synthesizer synthesizer;

	public Sintetizador() {
		try {
			synthesizer = Central.createSynthesizer(null);
			synthesizer.allocate();
			synthesizer.resume();
		} catch (IllegalArgumentException | EngineException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AudioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EngineStateError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sayIt(String phrase) {
		try {
			synthesizer.speakPlainText(phrase, null);
			synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);
		} catch (IllegalArgumentException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}
