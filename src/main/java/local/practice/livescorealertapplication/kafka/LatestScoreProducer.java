package local.practice.livescorealertapplication.kafka;

import local.practice.livescorealertapplication.model.Score;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class LatestScoreProducer {

	private static final Logger logger = LoggerFactory.getLogger(LatestScoreProducer.class);

	@Value("${spring.kafka.topic-name}")
	private String topicName;

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void broadcastScore(Score score) {
		logger.info("Broadcasting latest score : {}", score);
		this.kafkaTemplate.send(topicName, score.toString());
	}
}
