package com.example.intensiveproject.crypto.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.intensiveproject.crypto.di.ManageViewModels
import com.example.intensiveproject.databinding.FragmentInfoBinding

class CryptoFragment : Fragment() {

    private var _binding: FragmentInfoBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: CryptoViewModel
    private lateinit var uiState: CryptoUiState

    private val showUi: () -> Unit = {
        uiState.update(
            dateView = binding.dateTextView,
            priceView = binding.priceTextView,
            submitView = binding.submitButton
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val manageViewModels = activity as ManageViewModels
        viewModel = manageViewModels.viewModel(CryptoViewModel::class.java)

        val clearAndNavigate: () -> Unit = {
            viewModel.clearBeforeNextInfo()
            manageViewModels.clear(CryptoViewModel::class.java)
            (requireActivity() as CryptoNavigation).navigateFromCryptoScreen()
        }

        binding.submitButton.setOnClickListener {
            uiState = viewModel.submit
            showUi.invoke()
            uiState.navigate(clearAndNavigate)
        }

        if (savedInstanceState == null) {
            uiState = viewModel.init()
            showUi.invoke()
        }
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

interface CryptoNavigation {
    fun navigateFromCryptoScreen()
}