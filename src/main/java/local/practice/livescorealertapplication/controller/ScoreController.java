package local.practice.livescorealertapplication.controller;

import local.practice.livescorealertapplication.kafka.LatestScoreProducer;
import local.practice.livescorealertapplication.model.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/score")
public class ScoreController {

	private final LatestScoreProducer latestScoreProducer;

	@Autowired
	public ScoreController(LatestScoreProducer latestScoreProducer) {
		this.latestScoreProducer = latestScoreProducer;
	}

	@PostMapping(value = "/broadcast")
	public void broadcastScoreToSubscribedUsers(@RequestBody Score score) {
		this.latestScoreProducer.broadcastScore(score);
	}

}