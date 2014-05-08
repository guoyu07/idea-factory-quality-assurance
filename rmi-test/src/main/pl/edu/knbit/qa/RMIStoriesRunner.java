package pl.edu.knbit.qa;

import org.jbehave.core.InjectableEmbedder;
import org.jbehave.core.annotations.Configure;
import org.jbehave.core.annotations.UsingEmbedder;
import org.jbehave.core.annotations.UsingSteps;
import org.jbehave.core.annotations.spring.UsingSpring;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.embedder.StoryControls;
import org.jbehave.core.failures.FailingUponPendingStep;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.spring.SpringAnnotatedEmbedderRunner;
import org.jbehave.core.reporters.CrossReference;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.swing.text.html.HTML;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import static java.util.Arrays.asList;
import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;
import static org.jbehave.core.reporters.Format.*;

@RunWith(SpringAnnotatedEmbedderRunner.class)
@Configure(using = MostUsefulConfiguration.class, pendingStepStrategy = FailingUponPendingStep.class)
@UsingEmbedder(embedder = Embedder.class, generateViewAfterStories = true, ignoreFailureInStories = true, ignoreFailureInView = false, storyTimeoutInSecs = 600, threads = 1, metaFilters = "-skip")
@UsingSpring(resources = {"rmi-tests.xml"})
@UsingSteps
public class RMIStoriesRunner extends InjectableEmbedder {


    @Test
    public void run() throws Throwable {
        CrossReference crossReference = new CrossReference().withJsonOnly().withOutputAfterEachStory(true)
                .excludingStoriesWithNoExecutedScenarios(false);

        Format[] formats = new Format[]{XML, CONSOLE, HTML};
        StoryReporterBuilder reporterBuilder = new StoryReporterBuilder()
                .withCodeLocation(codeLocationFromClass(RMIStoriesRunner.class)).withFailureTrace(true)
                .withFailureTraceCompression(true).withDefaultFormats().withFormats(formats)
                .withCrossReference(crossReference);

        Configuration configuration = injectedEmbedder().configuration();
        configuration.useFailureStrategy(new FailingUponPendingStep())
                .useStoryControls(new StoryControls().doResetStateBeforeScenario(true)).useStepMonitor(crossReference.getStepMonitor())
                .useStoryLoader(new LoadFromClasspath(RMIStoriesRunner.class))
                .useStoryReporterBuilder(reporterBuilder);


        injectedEmbedder().runStoriesAsPaths(getStoryPathFilter());
    }

    private List<String> getStoryPathFilter() throws IOException {
        String storyPathFilter = System.getProperty("storyFilter", "*") + ".story";
        List<String> storyPaths = new StoryFinder().findPaths(codeLocationFromClass(this.getClass()).getFile(),
                asList(storyPathFilter), null);
        return storyPaths;

    }
}