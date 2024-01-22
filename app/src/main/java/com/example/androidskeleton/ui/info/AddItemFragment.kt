package com.example.androidskeleton.ui.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.androidskeleton.R
import com.example.androidskeleton.data.datamodels.Article
import com.example.androidskeleton.databinding.FragmentAddItemBinding
import com.example.androidskeleton.ui.viewmodel.ArticleViewModel


class AddItemFragment : Fragment() {

    private var _binding: FragmentAddItemBinding? = null
    private val binding get() = _binding!!

    private val articleViewModel: ArticleViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAddItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imageButtonCamera.setOnClickListener {

        }
        //val item = articleViewModel.getItem()
        binding.buttonSave.setOnClickListener {
            val title = _binding?.editTextTitle?.text.toString()
            val description = _binding?.editTextDescription?.text.toString()
            val price = _binding?.editTextPrice?.text.toString()

            articleViewModel.insertArticles(
                Article(
                    title = title,
                    description = description,
                    price = price.toFloat(),
                    imageURI = "image"
                )
            )
            findNavController().navigate(R.id.action_addItemFragment_to_listFragment)
        }

        binding.buttonCancel.setOnClickListener{
            findNavController().navigate(R.id.action_addItemFragment_to_listFragment)

        }
    }

    fun updateView(item: Article){
        binding.editTextTitle
    }


}