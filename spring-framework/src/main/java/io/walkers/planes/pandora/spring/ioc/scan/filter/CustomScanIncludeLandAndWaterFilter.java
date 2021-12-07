package io.walkers.planes.pandora.spring.ioc.scan.filter;

import io.walkers.planes.pandora.spring.ioc.scan.annotation.Land;
import io.walkers.planes.pandora.spring.ioc.scan.annotation.Water;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * 自定义的扫描过滤器，同时被 {@link Land} 和 {@link Water} 标记
 *
 * @author Planeswalker23
 * @date 2021/12/6
 */
public class CustomScanIncludeLandAndWaterFilter implements TypeFilter {
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        MergedAnnotations annotations = annotationMetadata.getAnnotations();
        boolean present1 = annotations.isPresent(Land.class);
        boolean present2 = annotations.isPresent(Water.class);
        return present1 && present2;
    }
}
