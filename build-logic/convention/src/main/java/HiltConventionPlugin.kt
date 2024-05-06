import com.example.convention.applyDependencyImpl
import com.example.convention.applyDependencyKapt
import com.example.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project

class HiltConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("dagger.hilt.android.plugin")
                apply("kotlin-kapt")
            }

            applyDependencyImpl(dependencies, libs, listOf("hilt.android"))
            applyDependencyKapt(dependencies, libs, listOf("hilt.android.compiler"))
        }
    }

}