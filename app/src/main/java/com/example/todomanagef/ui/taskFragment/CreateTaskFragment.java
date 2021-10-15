package com.example.todomanagef.ui.taskFragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.todomanagef.R;
import com.example.todomanagef.databinding.FragmentCreateTaskBinding;

public class CreateTaskFragment extends Fragment {

    private FragmentCreateTaskBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCreateTaskBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        santTask();
    }

    private void santTask() {
        binding.addTask.setOnClickListener(view -> {
            String task = binding.add.getText().toString();

            Bundle bundle = new Bundle();
            bundle.putSerializable("bundle", task);
            CreateTaskFragment.this.getParentFragmentManager().setFragmentResult("request", bundle);
            NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_content_main);
            navController.navigateUp();
        });

    }

}