package com.logicbig.example.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyConfigurationService {
    private final MyConfigurationRepository configurationRepository;
    @Autowired
    public MyConfigurationService(MyConfigurationRepository configurationRepository){
        this.configurationRepository = configurationRepository;
    }
    public MyConfiguration addConfiguration(MyConfiguration configuration){
        return configurationRepository.save(configuration);
    }
    public MyConfiguration getConfiguration(String propiedad){
        return configurationRepository.findByPropiedad(propiedad).get(1);
    }
    public List<MyConfiguration> getAllConfiguration(){
        return configurationRepository.findAll();
    }
    public MyConfiguration updateConfiguration(MyConfiguration configuration){
        if(configurationRepository.findByPropiedad(configuration.getPropiedad()).size() == 0){
            return configurationRepository.save(configuration);
        }
        return null;
    }
    public void deleteConfiguration(Long propiedad){
        configurationRepository.deleteById(propiedad);
    }

    public void flush() {
        configurationRepository.flush();
    }

    public String getValorOfPremio() {
        return configurationRepository.findByPropiedad("premio").get(0).getValor();
    }
}
